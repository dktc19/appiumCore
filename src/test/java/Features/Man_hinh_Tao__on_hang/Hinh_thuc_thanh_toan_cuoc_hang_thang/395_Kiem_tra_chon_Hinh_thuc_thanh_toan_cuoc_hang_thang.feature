# Automation priority: null
# Test case importance: Low
# language: en
Feature: Kiểm tra chọn Hình thức thanh toán cước hàng tháng

	Scenario Outline: Kiểm tra chọn Hình thức thanh toán cước hàng tháng
		Given Tại màn hình Tạo đơn hàng
		When Chọn option <HinhThucThanhToanCuoc> trong Danh sách
		Then Kiểm tra hiển thị <HinhThucThanhToanCuoc> được chọn trên giao diện

		@1
		Examples:
		| HinhThucThanhToanCuoc |
		| "Qua ngân hàng(ATM/Chuyển khoản/SMS/Tại quầy ngân hàng...)" |

		@2
		Examples:
		| HinhThucThanhToanCuoc |
		| "Tại quầy giao dịch của FPT Telecom" |

		@3
		Examples:
		| HinhThucThanhToanCuoc |
		| "Tại địa chỉ khách hàng" |

		@4
		Examples:
		| HinhThucThanhToanCuoc |
		| "Khấu trừ tự động qua ngân hàng" |

		@5
		Examples:
		| HinhThucThanhToanCuoc |
		| "Qua đối tác thu hộ tại quầy (FPT shop/Payoo)" |

		@6
		Examples:
		| HinhThucThanhToanCuoc |
		| "Thanh toán Online FPT Telecom" |

		@7
		Examples:
		| HinhThucThanhToanCuoc |
		| "Qua đối tác thu hộ online (VNPay/ VTC/Moca/Ví Momo/TCB-Mobile)" |

		@8
		Examples:
		| HinhThucThanhToanCuoc |
		| "Thanh toán tự động FPT Telecom" |