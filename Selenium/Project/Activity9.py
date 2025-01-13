# Import necessary packages
from selenium import webdriver
from selenium.webdriver.common.by import By

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
    sales_button = driver.find_element(By.ID, "grouptab_0")
    
    # Hover over the "Sales" menu item to reveal the "Leads" option
    from selenium.webdriver.common.action_chains import ActionChains
    actions = ActionChains(driver)
    actions.move_to_element(sales_button).perform()
    
    # Find the "Leads" option
    leads_option = driver.find_element(By.ID, "moduleTab_9_Leads")
    
    # Click the "Leads" option
    leads_option.click()
    
    # Wait for the list table to be visible
    from selenium.webdriver.support.ui import WebDriverWait
    from selenium.webdriver.support import expected_conditions as EC
    wait = WebDriverWait(driver, 30)
    list_table = wait.until(EC.visibility_of_element_located((By.CSS_SELECTOR, ".list")))
    
    # Find all rows in the table
    rows = list_table.find_elements(By.TAG_NAME, "tr")
    
    print("Total rows (including headers):", len(rows))
    
    # Print names and user names for the first 10 valid rows
    name_count = 0
    for i in range(2, len(rows)):  # Start from the 3rd row (index 2)
        row = rows[i]
        cells = row.find_elements(By.TAG_NAME, "td")
        
        if len(cells) <= 7:
            continue  # Skip rows with less than 8 cells
        
        name = cells[2].text  # Assuming name is in the 3rd column (index 2)
        lead_user_name = cells[7].text  # Assuming userName is in the 8th column (index 7)
        
        if name == "(1 - 20 of 54)":
            continue  # Skip rows with empty or non-relevant names
        
        print(f"Name: {name}, UserName: {lead_user_name}")
        name_count += 1
        
        if name_count == 10:
            break