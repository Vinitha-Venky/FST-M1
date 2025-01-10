# Import necessary packages
from selenium import webdriver
from selenium.webdriver.common.by import By

# Start the driver using with statement
with webdriver.Firefox() as driver:
    # Open the page
    driver.get("http://alchemy.hguy.co/crm")
    
    # Find the footer element by its XPath
    page_footer = driver.find_element(By.XPATH, '//*[@id="admin_options"]')
    footer_text = page_footer.text
    
    # Log and print the content of the footer
    print("Content in footer:", footer_text)

