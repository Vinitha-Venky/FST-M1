from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.select import Select


with webdriver.Firefox() as driver:
    driver.get("https://training-support.net/webelements/selects")
    print("Page title is: ", driver.title)

   
    dropdown = driver.find_element(By.CSS_SELECTOR, "select.h-10")
    singleSelect = Select(dropdown)


    singleSelect.select_by_visible_text("Two")
    print("Second option: " + singleSelect.first_selected_option.text)


    singleSelect.select_by_index(3)
    print("Third option: " + singleSelect.first_selected_option.text)

    singleSelect.select_by_value("four")
    print("Fourth option: " + singleSelect.first_selected_option.text)


    allOptions = singleSelect.options
    print("Options in the dropdown: ")
    for option in allOptions: 
        print(option.text)