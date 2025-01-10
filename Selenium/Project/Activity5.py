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
    
    # Find the navigation menu
    navigation_menu = driver.find_element(By.CSS_SELECTOR, ".desktop-toolbar")
    
    # Get the color of the navigation bar
    nav_color = navigation_menu.value_of_css_property("color")
    print("The color of the navigation bar is:", nav_color)

