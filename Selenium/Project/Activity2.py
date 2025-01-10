# Import necessary packages
from selenium import webdriver
from selenium.webdriver.common.by import By

# Start the driver using with statement
with webdriver.Firefox() as driver:
    # Navigate to the URL
    driver.get("http://alchemy.hguy.co/crm")
    
    # Find the image element by its XPath
    page_heading = driver.find_element(By.XPATH, "//img[@alt='SuiteCRM']")
    img_header = page_heading.get_attribute("src")
    
    # Log and print the URL of the image
    print("URL is:", img_header)
    assert img_header is not None, "Image header URL should not be None"

