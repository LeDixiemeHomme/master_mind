@default_sequences
Feature: show the number of well placed color and the number of correct but misplaced color from a sequence

  Scenario Outline: Returning a good number of correct but misplaced color and a good number of well placed color
    Given The color sequence to guess <sequence to guess>
    And The proposed color sequence <proposed sequence>
    When The answerer compare the two sequences
    Then The number of well placed color returned should be equal to <number of well placed color>
    And the number of correct but misplaced color returned should be equal to <number of correct but misplaced color>
    Examples:
      | sequence to guess | proposed sequence | number of well placed color | number of correct but misplaced color |
      | "goal"            | "fail_1"          | 0                           | 0                                     |
      | "goal"            | "fail_2"          | 1                           | 0                                     |
      | "goal"            | "fail_3"          | 2                           | 0                                     |
      | "goal"            | "fail_4"          | 3                           | 0                                     |
      | "goal"            | "success"         | 4                           | 0                                     |
      | "recto"           | "verso"           | 0                           | 4                                     |
      | "sequence_5"      | "sequence_6"      | 1                           | 1                                     |
      | "sequence_6"      | "sequence_7"      | 2                           | 2                                     |
