# Automation priority: null
# Test case importance: Low
# language: en
Feature: Check Tap Button thanh toán với Hình thức thanh toán là MB Bank

	Scenario: Check Tap Button thanh toán với Hình thức thanh toán là MB Bank
		Given Tại màn hình Thanh toán với Hình thức thanh toán là MB Bank
		When Nhấn Button Thanh toán
		Then Chuyển sang màn hình FPT Telecom Payment Gateway