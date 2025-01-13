# Import necessary packages
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

# Start the driver using with statement
with webdriver.Firefox() as driver:
    # Open the page
    driver.get("http://alchemy.hguy.co/crm")
    
    # Find username and password fields
    username_field = driver.find_element(By.ID, "user_name")
    password_field = driver.find_element(By.ID, "username_password")
    login_button = driver.find_element(By.ID, "bigbutton")
    
    # Enter credentials
    username_field.send_keys("admin")
    password_field.send_keys("pa$$w0rd")
    
    # Click the submit button
    login_button.click()
    
    # Find the "Sales" menu item
    sales_menu = driver.find_element(By.ID, "grouptab_0")
    
    # Hover over the "Sales" menu item to reveal the "Leads" option
    actions = ActionChains(driver)
    actions.move_to_element(sales_menu).perform()
    
    # Wait for the "Leads" option to be visible and click it
    wait1 = WebDriverWait(driver, 30)
    lead_option = wait1.until(EC.visibility_of_element_located((By.XPATH, "//*[@id='moduleTab_9_Leads']")))
    lead_option.click()
    
    # Wait for the "Additional Details" button to be visible and click it
    wait2 = WebDriverWait(driver, 10)
    additional_info = wait2.until(EC.visibility_of_element_located((By.CSS_SELECTOR, "[title='Additional Details']")))
    additional_info.click()
    
    # Find the phone number element and print its text
    phone_number = driver.find_element(By.CSS_SELECTOR, ".phone")
    print("The phone number displayed on the leads pop up is:", phone_number.text)