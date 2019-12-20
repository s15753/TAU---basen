*** Variable ***
${starting_page}    http://automationpractice.com/index.php
${login_page}    http://automationpractice.com/index.php?controller=authentication&back=my-account
${login_button_id}    id=SubmitLogin
${email_field_id}    id=email
${passwd_field_id}    id=passwd
${email_correct}    testrob@test.pl
${passwd_correct}    qwert1
${my_acccount_xpath}    xpath=/html/body/div[1]/div[2]/div/div[3]/div/h1
${my_account_text}    MY ACCOUNT
${login_error_msg_xpath}    xpath=/html/body/div[1]/div[2]/div/div[3]/div/div[1]/ol/li
${login_error_msg_text}    Authentication failed.
${email_create_id}    id=email_create
${submit_create_id}    id=SubmitCreate
${create_account_xpath}    xpath=/html/body/div[1]/div[2]/div/div[3]/div/div/h1
${create_account_text}    Create an account
${register_account_xpath}    xpath=/html/body/div[1]/div[2]/div/div[3]/div/div/form/div[1]/h3
${register_account_text}    YOUR PERSONAL INFORMATION
${gender_id}    id=id_gender1
${first_name_id}    id=customer_firstname
${last_name_id}    id=customer_lastname
${registration_passwd}    id=passwd
${address_id}    id=address1
${address_text}    301 E Dave Ward Dr
${city_id}    id=city
${city_text}    Conway
${state_id}    id=id_state
${zip_code_id}    id=postcode
${zip_code_text}    72032
${phone_nbr_id}    id=phone_mobile
${reg_submit_id}    id=submitAccount