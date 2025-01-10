# Import necessary packages
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

# Start the driver using with statement
with webdriver.Firefox() as driver:
    # Initialize WebDriverWait
    wait = WebDriverWait(driver, 10)
    
    # Open the page
    driver.get("https://alchemy.hguy.co/crm")
    
    # Find username and password fields
    username_field = driver.find_element(By.ID, "user_name")
    password_field = driver.find_element(By.ID, "username_password")
    
    # Enter credentials
    username_field.send_keys("admin")
    password_field.send_keys("pa$$w0rd")
    
    # Click the submit button
    driver.find_element(By.ID, "bigbutton").click()
    
    # Wait for the dashboard tab to be visible
    wait.until(EC.visibility_of_element_located((By.ID, "tab0")))
    
    # Assert login message
    login_message = driver.find_element(By.ID, "tab0").text
    assert login_message == "SUITECRM DASHBOARD", f"Expected 'SUITECRM DASHBOARD' but got '{login_message}'"
    
    # Print the login message
    print("Login message:", login_message)

