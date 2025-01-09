from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.wait import WebDriverWait


with webdriver.Firefox() as driver:
   
    wait = WebDriverWait(driver, timeout=10)
   
    driver.get("https://training-support.net/webelements/dynamic-content")
    
    print("Page title is: ", driver.title)

  
    driver.find_element(By.ID, "genButton").click()
   
    if wait.until(EC.text_to_be_present_in_element((By.ID, "word"), "release")):
      
        print("Word found: ", driver.find_element(By.ID, "word").text)