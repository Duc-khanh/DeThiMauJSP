package com.codegym.managecustomer.configuration;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{AppConfiguration.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding("UTF-8");
        encodingFilter.setForceEncoding(true);
        return new Filter[]{encodingFilter};
    }
}

//        Người dùng gửi yêu cầu từ trình duyệt (GET/POST).
//
//        CustomerController nhận yêu cầu và xử lý.
//
//        CustomerServiceImpl gọi CustomerRepository để làm việc với CSDL.
//
//        Kết quả (giao diện HTML + dữ liệu) được trả lại cho trình duyệt.

//
//        Ví dụ: http://localhost:8080/customers
//
//        Controller nhận URL /customers
//
//        Gọi Service → gọi Repository
//
//        Repository dùng JPA truy vấn DB
//
//        Kết quả trả về View (HTML) hiển thị danh sách khách hàng
