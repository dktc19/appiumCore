# Automation priority: null
# Test case importance: Low
# language: en
Feature: Check Tap Button thanh toán với Hình thức thanh toán là Tiền mặt

	Scenario: Check Tap Button thanh toán với Hình thức thanh toán là Tiền mặt
		Given Tại màn hình Thanh toán với Hình thức thanh toán là Tiền mặt
		When Nhấn Button Thanh toán
		Then Hiển thị màn hình Thanh toán thành công