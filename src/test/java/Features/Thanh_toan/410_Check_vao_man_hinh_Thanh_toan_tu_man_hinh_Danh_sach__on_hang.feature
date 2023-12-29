# Automation priority: null
# Test case importance: Low
# language: en
Feature: Check vào màn hình Thanh toán từ màn hình Danh sách đơn hàng

	Scenario: Check vào màn hình Thanh toán từ màn hình Danh sách đơn hàng
		Given Tại màn hình Danh sách đơn hàng, Chọn đơn hàng Chưa thanh toán
		When Tap button 'Thanh toán'
		Then Chuyển sang màn hình Thanh toán