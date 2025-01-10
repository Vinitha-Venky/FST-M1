from selenium import webdriver
from selenium.webdriver.common.by import By

# Start the Driver using with statement
with webdriver.Firefox() as driver:
    # Navigate to the URL
    driver.get("http://alchemy.hguy.co/crm")
    
    # Print the title of the page
    print("Page title is:", driver.title)
    
    # Assert the page title
    assert driver.title == "SuiteCRM"