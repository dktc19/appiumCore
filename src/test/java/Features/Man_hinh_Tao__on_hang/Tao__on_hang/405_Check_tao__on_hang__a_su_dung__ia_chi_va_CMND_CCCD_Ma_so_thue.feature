# Automation priority: null
# Test case importance: Low
# language: en
Feature: Check tạo đơn hàng đã sử dụng Địa chỉ và CMND/CCCD/Mã số thuế

	Scenario: Check tạo đơn hàng đã sử dụng Địa chỉ và CMND/CCCD/Mã số thuế
		Given Tại màn hình Tạo đơn hàng
		When Nhập thông tin đã được sử dụng trước đó
		And Nhấn button tạo đơn hàng
		Then App show popup thông báo 'Địa chỉ và CMND/CCCD/Mã số thuế này đã được sử dụng trước đó. Bạn có muốn tiếp tục tạo đơn hàng không?'