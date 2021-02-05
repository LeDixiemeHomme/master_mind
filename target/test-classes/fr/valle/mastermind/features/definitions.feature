Feature: Definitions

  @default_sequences
  Scenario: Default sequences
    Then the available sequences should be at least:
      | name       | color_1 | color_2 | color_3 | color_4 |
      | goal       | red     | red     | red     | red     |
      | fail_1     | blue    | blue    | blue    | blue    |
      | fail_2     | red     | blue    | blue    | blue    |
      | fail_3     | red     | red     | blue    | blue    |
      | fail_4     | red     | red     | red     | blue    |
      | success    | red     | red     | red     | red     |
      | recto      | red     | blue    | green   | yellow  |
      | verso      | yellow  | green   | blue    | red     |
      | sequence_5 | green   | green   | yellow  | yellow  |
      | sequence_6 | yellow  | yellow  | yellow  | red     |
      | sequence_7 | yellow  | yellow  | red     | yellow  |
