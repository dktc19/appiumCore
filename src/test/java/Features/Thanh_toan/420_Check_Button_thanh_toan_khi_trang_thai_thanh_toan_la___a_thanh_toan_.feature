# Automation priority: null
# Test case importance: Low
# language: en
Feature: Check Button thanh toán khi trạng thái thanh toán là 'Đã thanh toán'

	Scenario: Check Button thanh toán khi trạng thái thanh toán là 'Đã thanh toán'
		Given Tại Danh sách đơn hàng, Tap xem chi tiết đơn hàng
		When Tại màn hình Chi tiết đơn hàng, Check Button thanh toán
		Then Ẩn button 'Thanh toán' khi trạng thái thanh toán là 'Đã thanh toán'