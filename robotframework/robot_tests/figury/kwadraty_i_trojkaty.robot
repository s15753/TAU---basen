*** Settings ***
Library    String
Library    OperatingSystem
Library    Process
Resource   resources.resource

*** Test Cases ***
Nie podano argumentow
    [Documentation]    Test nieudanego odpalenia 
    ...    programu - brak podanych boków.
    ${result}    Run Process    ${directory}/figury
    Should Be Equal As Strings    ${result.stdout}    ${error_args_text}
    
Za duzo argumentow
    [Documentation]    Test nieudanego odpalenia 
    ...    programu - zbyt wiele argumentow.
    ${result}    Run Process    ${directory}/figury    2    4    2    3    3
    Should Be Equal As Strings    ${result.stdout}    ${error_args_text}
    
Trojkat - zle boki
    [Documentation]    Test trójkąta - niepoprawne 
    ...    długości boków.
    ${result}    Run Process    ${directory}/figury    2    5    20
    Log    ${result.stdout}
    Should Be Equal As Strings    ${result.stdout}    ${error_triangle_text}
    
Trojkat rownoboczny - Happy Path
    [Documentation]    Test trójkąta równobocznego 
    ...    programu - zbyt wiele argumentow.
    ${result}    Run Process    ${directory}/figury    4    4    4
    Should Be Equal As Strings    ${result.stdout}    ${equilateral triangle_text}

Trojkat rownoramienny v1 - Happy Path
    [Documentation]    Test trójkąta równoramiennego.
    ${result}    Run Process    ${directory}/figury    4    4    3
    Should Be Equal As Strings    ${result.stdout}    ${isosceles_triangle_text}
    
Trojkat rownoramienny v2 - Happy Path
    [Documentation]    Test trójkąta równoramiennego.
    ${result}    Run Process    ${directory}/figury    4    3    4
    Should Be Equal As Strings    ${result.stdout}    ${isosceles_triangle_text}
    
Trojkat rownoramienny v3 - Happy Path
    [Documentation]    Test trójkąta równoramiennego.
    ${result}    Run Process    ${directory}/figury    3    4    4
    Should Be Equal As Strings    ${result.stdout}    ${isosceles_triangle_text}
    
Trojkat roznoramienny - Happy Path
    [Documentation]    Test trójkąta różnoramiennego.
    ${result}    Run Process    ${directory}/figury    3    4    5
    Should Be Equal As Strings    ${result.stdout}    ${multiarmed_triangle_text}
    
Kwadrat - Happy Path
    [Documentation]    Test kwadratu
    ${result}    Run Process    ${directory}/figury    3    3    3    3
    Should Be Equal As Strings    ${result.stdout}    ${square_text}
    
Prostokat v1 - Happy Path
    [Documentation]    Test prostokąta
    ${result}    Run Process    ${directory}/figury    3    2    2    3
    Should Be Equal As Strings    ${result.stdout}    ${rectangle_text}
    
Prostokat v2 - Happy Path
    [Documentation]    Test prostokąta
    ${result}    Run Process    ${directory}/figury    3    3    2    2
    Should Be Equal As Strings    ${result.stdout}    ${rectangle_text}
    
Czworobok - Happy Path
    [Documentation]    Test czworokata
    ${result}    Run Process    ${directory}/figury    3    4    2    5
    Should Be Equal As Strings    ${result.stdout}    ${quadrangle_text}
    
Czworobok - zle boki
    [Documentation]    Test czworokata - niepoprawne
    ...    długości boków.
    ${result}    Run Process    ${directory}/figury    1    15    3    2
    Should Be Equal As Strings    ${result.stdout}    ${error_quadrangle_text}
