package ua.dlubovskyi.hms.controller;

import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.dlubovskyi.hms.dto.create.CreateDepartmentDto;
import ua.dlubovskyi.hms.entity.Department;
import ua.dlubovskyi.hms.entity.Role;
import ua.dlubovskyi.hms.entity.User;
import ua.dlubovskyi.hms.service.TokenService;
import ua.dlubovskyi.hms.service.impl.DepartmentService;
import ua.dlubovskyi.hms.service.impl.UserService;
import ua.dlubovskyi.hms.util.SecurityUtils;

import javax.websocket.server.PathParam;
import java.util.List;

import static ua.dlubovskyi.hms.entity.Role.SERVICE_ADMIN;

@RestController
public class DepartmentRest {

    private TokenService tokenService;
    private UserService userService;
    private SecurityUtils securityUtils;
    private ConversionService conversionService;
    private DepartmentService departmentService;

    public DepartmentRest(TokenService tokenService, UserService userService, SecurityUtils securityUtils, ConversionService conversionService, DepartmentService departmentService) {
        this.tokenService = tokenService;
        this.userService = userService;
        this.securityUtils = securityUtils;
        this.conversionService = conversionService;
        this.departmentService = departmentService;
    }

    @PutMapping("/department")
    public ResponseEntity<Department> createDepartment(@RequestHeader("Auth") String authToken,
                                                       @RequestBody CreateDepartmentDto createDepartmentDto) {
        if (securityUtils.isActionGrated(authToken, SERVICE_ADMIN, Role.HOSPITAL_ADMIN)) {
            String userId = tokenService.getUserIdByToken(authToken);
            User user = userService.findById(userId);
            Department department = conversionService.convert(createDepartmentDto, Department.class);
            if (user.getProfileType().equals(SERVICE_ADMIN.name()) ||
                    user.getHospitalId().equals(createDepartmentDto.getHospitalId())) {
                departmentService.createDepartment(department);
                return new ResponseEntity<>(department, HttpStatus.CREATED);
            }
        }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @GetMapping("/departments/{hospitalId}")
    private ResponseEntity<List<Department>> getDepartmentsHospitalId(@PathParam("hospitalId") String id) {
        return new ResponseEntity<>(departmentService.findByHospId(id), HttpStatus.OK);
    }
}
