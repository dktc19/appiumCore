# Automation priority: null
# Test case importance: Low
# language: en
Feature: Tạo đơn hàng khi book port auto thất bại

	Scenario: Tạo đơn hàng khi book port auto thất bại
		Given Tại màn hình tạo đơn hàng Chọn các thông tin bắt buộc
		When Không thực hiện book port
		And Nhấn button Tạo đơn hàng
		Then App show message: 'Vui lòng thực hiện thao tác bookport trước khi tạo đơn hàng.'