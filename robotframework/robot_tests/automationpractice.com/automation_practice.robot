*** Settings ***
Library    SeleniumLibrary
Library    String
Resource   resources.robot
Test Teardown    Close Browser

Library    OperatingSystem
*** Test Cases ***
Login - Happy Path
    [Documentation]    Test poprawnego logowania.
    Open Login Page
    Input Email    ${email_field_id}    ${email_correct}
    Input Password    ${passwd_field_id}    ${passwd_correct}
    Click Button    ${login_button_id}
    ${text}    Get Text    ${my_acccount_xpath}
    Should Be Equal As Strings    ${text}    ${my_account_text}
    Capture Page Screenshot
    
    
Login - Invalid Credentials
    [Documentation]    Test logowania z błędnym userem i hasłem.
    Open Login Page
    ${username}    Random Email
    ${password}    Random Password
    Input Email    ${email_field_id}    ${username}
    Input Password    ${passwd_field_id}    ${password}
    Click Button    ${login_button_id}
    ${error_text}    Get Text    ${login_error_msg_xpath}
    Should Be Equal As Strings    ${error_text}    ${login_error_msg_text}
    
Registration - Happy Path
    [Documentation]    Test pomyślnej rejestracji - tylko wymagane dane.
    Open Login Page
    ${username}    Random Email
    Input Email    ${email_create_id}    ${username}
    Click Button    ${submit_create_id}
    Wait Until Element Is Enabled    ${register_account_xpath}
    ${register_text}    Get Text    ${register_account_xpath}
    Should Be Equal As Strings    ${register_text}    ${register_account_text}
    Click Element    ${gender_id}
    ${name}    Random Data String
    Input Text    ${first_name_id}    ${name}
    ${last_name}    Random Data String
    Input Text    ${last_name_id}    ${name}
    ${passwd}    Random Password
    Input Password    ${registration_passwd}    ${passwd}
    Input Text    ${address_id}    ${address_text}
    Input Text    ${city_id}    ${city_text}
    Select From List By Value    ${state_id}    4
    Input Text    ${zip_code_id}    ${zip_code_text}
    ${phone_nbr}    Random Phone Number
    Input Text    ${phone_nbr_id}    ${phone_nbr}
    Click Button    ${reg_submit_id}
    ${text}    Get Text    ${my_acccount_xpath}
    Should Be Equal As Strings    ${text}    ${my_account_text}
    Capture Page Screenshot

*** Keyword ***
Open Login Page
    [Documentation]    Otwiera stronę logowania.
    Open Browser    ${login_page}    Firefox
    Element Should Be Visible    ${login_button_id}
    Capture Page Screenshot
    
Input Email
    [Documentation]    Uzupełnia nazwę usera w podanym polu.
    [Arguments]    ${email_field_locator}    ${email}
    Input Text    ${email_field_locator}    ${email}

Random Email
    [Documentation]    Tworzy randomowy email dla domeny random.com.
    ${random_string}    Generate Random String    8
    ${username}    Set Variable    ${random_string}@random.com
    [Return]    ${username}
    
Random Password
    [Documentation]    Tworzy randomowe hasło o długości 10 znaków.
    ${passwd}    Generate Random String    10
    [Return]    ${passwd}
    
Random Data String
    [Documentation]    Tworzy randomowy string zaczynający się z dużej litery.
    ${capital_letter}    Generate Random String    1    [UPPER]
    ${number}    Generate Random String    1    456789
    ${lower_letters}    Generate Random String    ${number}    [LOWER]
    ${data}    Set Variable    ${capital_letter}${lower_letters}
    [Return]    ${data}

Random Phone Number
    [Documentation]    Tworzy randomowy numer telefonu o długości 9 cyfr.
    ${number}    Generate Random String    9    0123456789
    [Return]    ${number}