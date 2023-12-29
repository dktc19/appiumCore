# Automation priority: null
# Test case importance: Low
# language: en
Feature: Kiểm tra Tap dịch vụ Internet

	Scenario Outline: Kiểm tra Tap dịch vụ Internet
		Given Truy cập màn hình Dịch vụ
		When Tại Combo tùy chọn của màn hình dịch vụ Tap dịch vụ Internet với <DiaChi>
		Then Hiển thị popup Internet

		@1
		Examples:
		| DiaChi |
		| "18 Nguyễn Tri Phương, p6, q5, HCM" |