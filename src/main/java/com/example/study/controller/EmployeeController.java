package com.example.study.controller;


import com.example.study.model.Employee;
import com.example.study.model.dto.UpdateEmployeeDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
@CrossOrigin(origins = "*", maxAge = 3600)
public interface EmployeeController {
    @RequestMapping(method = RequestMethod.POST)
    @PreAuthorize("hasAnyAuthority('USER_CREATE')")
    public ResponseEntity<?> createEmployee(@RequestBody Employee employee);

    @RequestMapping(value = "/{employeeId}", method = RequestMethod.PUT)
    @PreAuthorize("hasAnyAuthority('USER_UPDATE')")
    public ResponseEntity<?> updateEmployee(@RequestBody UpdateEmployeeDTO updateEmployeeDTO,
                                            @PathVariable(name = "employeeId") Integer employeeId);

    @RequestMapping(value = "/{employeeId}", method = RequestMethod.DELETE)
    @PreAuthorize("hasAnyAuthority('USER_DELETE')")
    public ResponseEntity<?> deleteEmployee(@PathVariable Integer employeeId);

    @RequestMapping(value = "/{companyId}", method = RequestMethod.GET)
    @PreAuthorize("hasAnyAuthority('USER_READ')")
    public ResponseEntity<?> findEmployeeByCompany(@PathVariable Integer companyId);
}
