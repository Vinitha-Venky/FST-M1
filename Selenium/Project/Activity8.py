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
    sales_button = driver.find_element(By.XPATH, "//*[@id='grouptab_0']")
    
    # Hover over the "Sales" menu item to reveal the "Accounts" option
    actions = ActionChains(driver)
    actions.move_to_element(sales_button).perform()
    
    # Wait for the "Accounts" option to be visible and click it
    wait1 = WebDriverWait(driver, 30)
    accounts_option = wait1.until(EC.visibility_of_element_located((By.XPATH, "//*[@id='moduleTab_9_Accounts']")))
    accounts_option.click()
    
    # Wait for the accounts table to be visible
    wait2 = WebDriverWait(driver, 30)
    accounts_table = wait2.until(EC.visibility_of_element_located((By.CSS_SELECTOR, ".list")))
    
    # Get all rows in the table
    rows = accounts_table.find_elements(By.TAG_NAME, "tr")
    print("Total rows (including headers):", len(rows))
    
    name_count = 0  # This will track how many odd-numbered names we have printed
    row_number = 1  # Start counting from row 1 (which will be the 3rd row)
    
    for i in range(2, len(rows)):  # Start from the 3rd row (index 2)
        row = rows[i]
        # Check if the row contains <td> elements
        cells = row.find_elements(By.TAG_NAME, "td")
        
        if not cells:
            continue  # Skip header rows or non-relevant rows
        
        # Identify the correct column for "Name" (3rd <td>)
        name = cells[2].text  # "Name" is in the 3rd <td> (index 2)
        
        # Skip any row that contains non-useful data like "Name: (1 - 20 of 54)"
        if not name or name == "(1 - 20 of 54)":
            continue  # Skip rows with empty or non-relevant names
        
        # Consider row 3 as row 1, row 5 as row 2, etc.
        if row_number % 2 != 0:  # This ensures odd-numbered rows starting from row 3
            print("Name:", name)
            name_count += 1  # Increment valid odd-numbered name count
            
            # Stop after printing 5 odd-numbered names
            if name_count == 5:
                break  # Exit the loop after printing 5 valid odd-numbered names
        
        row_number += 1  # Increment the row counter