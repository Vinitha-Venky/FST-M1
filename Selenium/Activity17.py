from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.select import Select


with webdriver.Firefox() as driver:   
    driver.get("https://training-support.net/webelements/selects")
    print("Page title is: ", driver.title)

    selectElement = driver.find_element(By.CSS_SELECTOR, "select.h-80")
    multiSelect = Select(selectElement)

     multiSelect.deselect_by_index(0)
    multiSelect.select_by_visible_text("HTML")

    for i in range(3, 6):
        multiSelect.select_by_index(i)
    multiSelect.select_by_value("nodejs")

    selectedOptions = multiSelect.all_selected_options
    print("Selected options are: ")
    for option in selectedOptions:
        print(option.text)


    multiSelect.deselect_by_index(4)

    selectedOptions = multiSelect.all_selected_options
    print("Selected options are: ")
    for option in selectedOptions:
        print(option.text)
