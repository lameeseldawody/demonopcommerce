@smoke
  Feature: user could add product to wishlist
  Scenario:user choose wishlist button
  When user click on wishlist button on this product HTC One M8 Android L 5.0 Lollipop
  Then verify the success message is displayed
  Scenario: The product must appear in wishlist page
  When user click on wishlist button on this product HTC One M8 Android L 5.0 Lollipop
  And user could click on close icon
  And user  click on Wishlist Tab on the top of the page
  Then verify that the product appear in wishlist page