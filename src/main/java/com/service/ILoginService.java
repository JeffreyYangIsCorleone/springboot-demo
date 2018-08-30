package com.service;

import java.util.Map;

public interface ILoginService {

    Map<String, Object> checkUserAccount(String account, String password);
}
