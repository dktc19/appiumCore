# Automation priority: null
# Test case importance: Low
# language: en
Feature: Check Tap Button thanh toán với Hình thức thanh toán là VNPay hoặc QR FoxPay

	Scenario: Check Tap Button thanh toán với Hình thức thanh toán là VNPay hoặc QR FoxPay
		Given Tại màn hình Thanh toán với Hình thức thanh toán là VNPay hoặc QR FoxPay
		When Nhấn Button Thanh toán
		Then Chuyển sang màn hình Thanh toán bằng QR Code