Feature: show the number of correct but misplaced color in a sequence

  Scenario: Returning a good number of correct but misplaced color
    Given The color sequence to guess "blue" "blue" "red" "blue"
    When The colorF sequence proposed is "green" "red" "green" "green"
    Then The number of correct but misplaced color should be equal to 1
