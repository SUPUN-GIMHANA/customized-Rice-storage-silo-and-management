//package com.sunmark.sunmark.controller;
//
//import com.sunmark.sunmark.service.CylinderService;
//import com.sunmark.sunmark.service.impl.CylinderState;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/v1/cylinders")
//@CrossOrigin(origins = "http://localhost:3000") // React default port
//public class CylinderController {
//
//    @Autowired
//    private CylinderService cylinderService;
//
//    @PostMapping("/update-parameters")
//    public String updateParameters(@RequestBody CylinderParametersRequest request) {
//        cylinderService.updateCylinderParameters(
//                request.getRadiusA(), request.getHeightA(),
//                request.getRadiusB(), request.getHeightB(),
//                request.getRadiusC(), request.getHeightC());
//        return "Cylinder parameters updated";
//    }
//
//    @PostMapping("/load")
//    public String load(@RequestParam int loadValue) {
//        return cylinderService.load(loadValue);
//    }
//
//    @PostMapping("/unload")
//    public String unload(@RequestParam int unloadValue) {
//        return cylinderService.unload(unloadValue);
//    }
//
//    @GetMapping("/state")
//    public CylinderState getState() {
//        return cylinderService.getCylinderState();
//    }
//}
//
//// DTO for parameters
//class CylinderParametersRequest {
//    private int radiusA, heightA;
//    private int radiusB, heightB;
//    private int radiusC, heightC;
//
//    // getters/setters
//    public int getRadiusA() { return radiusA; }
//    public void setRadiusA(int radiusA) { this.radiusA = radiusA; }
//    public int getHeightA() { return heightA; }
//    public void setHeightA(int heightA) { this.heightA = heightA; }
//    public int getRadiusB() { return radiusB; }
//    public void setRadiusB(int radiusB) { this.radiusB = radiusB; }
//    public int getHeightB() { return heightB; }
//    public void setHeightB(int heightB) { this.heightB = heightB; }
//    public int getRadiusC() { return radiusC; }
//    public void setRadiusC(int radiusC) { this.radiusC = radiusC; }
//    public int getHeightC() { return heightC; }
//    public void setHeightC(int heightC) { this.heightC = heightC; }
//}
