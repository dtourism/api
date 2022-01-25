package org.api.transaction;

import org.api.ApiApplicationTests;
import org.api.service.AreaService;
import org.api.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TransactionSpreadTest extends ApiApplicationTests {

    @Autowired
    private AreaService areaService;

    @Autowired
    private UserService userService;

    @Test
    public void redisSerializationTest() {
        areaService.deleteArea(3061);
    }
}
