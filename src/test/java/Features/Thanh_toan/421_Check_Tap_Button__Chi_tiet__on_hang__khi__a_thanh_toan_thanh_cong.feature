# Automation priority: null
# Test case importance: Low
# language: en
Feature: Check Tap Button "Chi tiết đơn hàng" khi đã thanh toán thành công

	Scenario: Check Tap Button "Chi tiết đơn hàng" khi đã thanh toán thành công
		Given Tại màn hình Thanh toán, Tap Button thanh toán và thực hiện thanh toán thành công
		When Tap Button 'Chi tiết đơn hàng'
		Then Chuyển sang màn hình Thông tin đơn hàng ở tab 'Thông tin đơn hàng'