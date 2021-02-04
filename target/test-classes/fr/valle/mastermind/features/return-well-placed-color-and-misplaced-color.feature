Feature: show the number of well placed color and the number of correct but misplaced color from a sequence

  Scenario: Returning a good number of correct but misplaced color
    Given The color sequence to guess "blue" "blue" "red" "blue"
    When The color sequence proposed is "green" "red" "green" "green"
    Then The number of correct but misplaced color should be equal to 1


  Scenario: Returning a good number of well placed color
    Given The color sequence to guess "red" "blue" "blue" "blue"
    When The color sequence proposed is "red" "green" "green" "green"
    Then The number of well placed color should be equal to 1
