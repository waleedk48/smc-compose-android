package com.servicemycar.android

import android.widget.CheckBox
import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.filterToOne
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onChildren
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.rememberNavController
import com.servicemycar.android.models.ServiceModel
import com.servicemycar.android.ui.screens.main.orderinfo.OrderInformationScreen
import org.junit.Rule
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class OrderInformationScreenKtTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @org.junit.Test
    fun testOrderInformationScreen() {
        // Set up the test environment
        composeTestRule.setContent {
            OrderInformationScreen(
                navController = rememberNavController(),
                serviceModel = ServiceModel(
                    id = "1",
                    name = "Information"
                ) // Provide a mock or test instance if needed
            )
        }

        // Check if the title is displayed
        composeTestRule.onNodeWithText("Order Information").assertIsDisplayed()

        // Check if the "Select Parts" header is displayed
        composeTestRule.onNodeWithText("Select Parts").assertIsDisplayed()

        // Check the After Market Parts list item
        composeTestRule.onNodeWithText("After Market Parts").performClick()
        composeTestRule.onNodeWithText("After Market Parts").assertIsDisplayed()
        composeTestRule.onNodeWithText("After Market Parts").assertIsDisplayed()
//        composeTestRule.onNodeWithText("After Market Parts")
//            .onChildren().filterToOne(SemanticsMatcher(description = "Checkbox", matcher = {true}))
//            .assetId
//            .onChildren().filterIsInstance<Checkbox>().onFirst().assertIsChecked()

        // Check the Genuine Parts list item
        composeTestRule.onNodeWithText("Genuine Parts").performClick()
        composeTestRule.onNodeWithText("Genuine Parts").assertIsDisplayed()
//        composeTestRule.onNodeWithText("Genuine Parts")
//            .onChildren().filterIsInstance<Checkbox>().onFirst().assertIsChecked()

        // Check that only one can be selected at a time
//        composeTestRule.onNodeWithText("After Market Parts").assertIsNotChecked()

        // Check concerns section
        composeTestRule.onNodeWithText("Concerns").assertIsDisplayed()
        composeTestRule.onNodeWithText("Add").performClick() // Click the Add button

        // Verify that the input field for the first concern is displayed
      //  composeTestRule.onNodeWithText("Concern One").assertIsDisplayed()

        // Click Continue button
        composeTestRule.onNodeWithText("Continue").performClick()

        // Assert navigation or state change (you may need to use a mocking framework for navigation)
        // This part depends on how you handle navigation in your app
    }
}