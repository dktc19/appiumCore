# Automation priority: null
# Test case importance: Low
# language: en
Feature: Kiểm tra thông tin đơn hàng khi mua dịch vụ net có thêm Extra 1

	Scenario Outline: Kiểm tra thông tin đơn hàng khi mua dịch vụ net có thêm Extra 1
		Given Truy cập màn hình Dịch vụ
		When Tại popup Internet Tap Dropdown list Gói dịch vụ Net <DiaChi>
		And Chọn Gói dịch vụ <DichVu> và Gói tính cước Net <GoiTinhCuoc>
		And Tap button Xác nhận
		And Tap Icon Thêm Extra
		And Chọn Gói dịch vụ <DichVuExtra> và Gói tính cước Extra <GoiTinhCuoc>
		Then Hiển thị thông tin đã chọn ở màn hình Tạo đơn hàng và Highlight Icon Internet tại màn hình Dịch vụ

		@1
		Examples:
		| DiaChi | DichVu | DichVuExtra | GoiTinhCuoc |
		| "18 Nguyễn Tri Phương, p6, q5, HCM" | "FTTH - Super100" | "UltraFast" | "Gói 6T (6T+0)" |

		@10
		Examples:
		| DiaChi | DichVu | DichVuExtra | GoiTinhCuoc |
		| "18 Nguyễn Tri Phương, p6, q5, HCM" | "LUX - 500" | "IP Front" | "Gói 7T (6T+1)" |

		@11
		Examples:
		| DiaChi | DichVu | DichVuExtra | GoiTinhCuoc |
		| "18 Nguyễn Tri Phương, p6, q5, HCM" | "LUX - 800" | "IP Front" | "Gói 7T (6T+1)" |

		@12
		Examples:
		| DiaChi | DichVu | DichVuExtra | GoiTinhCuoc |
		| "18 Nguyễn Tri Phương, p6, q5, HCM" | "Meta" | "UltraFast" | "Gói 7T (6T+1)" |

		@2
		Examples:
		| DiaChi | DichVu | DichVuExtra | GoiTinhCuoc |
		| "18 Nguyễn Tri Phương, p6, q5, HCM" | "FTTH - Super150" | "FSafe" | "Gói 7T (6T+1)" |

		@3
		Examples:
		| DiaChi | DichVu | DichVuExtra | GoiTinhCuoc |
		| "18 Nguyễn Tri Phương, p6, q5, HCM" | "FTTH - Super200" | "IP Front" | "Gói 12T (12T+0)" |

		@4
		Examples:
		| DiaChi | DichVu | DichVuExtra | GoiTinhCuoc |
		| "18 Nguyễn Tri Phương, p6, q5, HCM" | "FTTH - Super250" | "IP Front" | "Gói 12T (12T+0)" |

		@5
		Examples:
		| DiaChi | DichVu | DichVuExtra | GoiTinhCuoc |
		| "18 Nguyễn Tri Phương, p6, q5, HCM" | "FTTH - Super30" | "UltraFast" | "Gói 7T (6T+1)" |

		@6
		Examples:
		| DiaChi | DichVu | DichVuExtra | GoiTinhCuoc |
		| "18 Nguyễn Tri Phương, p6, q5, HCM" | "FTTH - Super400" | "UltraFast" | "Gói 7T (6T+1)" |

		@7
		Examples:
		| DiaChi | DichVu | DichVuExtra | GoiTinhCuoc |
		| "18 Nguyễn Tri Phương, p6, q5, HCM" | "FTTH - Super500" | "UltraFast" | "Gói 12T (12T+0)" |

		@8
		Examples:
		| DiaChi | DichVu | DichVuExtra | GoiTinhCuoc |
		| "" | "" | "UltraFast" | "Gói 12T (12T+0)" |

		@9
		Examples:
		| DiaChi | DichVu | DichVuExtra | GoiTinhCuoc |
		| "" | "" | "UltraFast" | "Gói 7T (6T+1)" |