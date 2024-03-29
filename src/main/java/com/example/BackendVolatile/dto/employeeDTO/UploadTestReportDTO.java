package com.example.BackendVolatile.dto.employeeDTO;

import com.example.BackendVolatile.dto.taskDTO.File;
import com.example.BackendVolatile.util.constant.ParamFormatErrorConstant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
public class UploadTestReportDTO {

    @NotNull(message = ParamFormatErrorConstant.TASK_ID_CANNOT_BE_NULL)
    @Min(value = 1, message = ParamFormatErrorConstant.TASK_ID_DONT_EXIST)
    private Long taskId;

    @Valid
    private TestReport testReport;

    @NotNull
    public String getDefectExplain(){
        return testReport.getDefectExplain();
    }

    @NotNull
    public String getReportName(){
        return testReport.getReportName();
    }

    @NotNull
    public String getDefectReproductionStep(){
        return testReport.getDefectReproductionStep();
    }

    @NotNull
    public String getTestEquipmentInformation(){
        return testReport.getTestEquipmentInformation();
    }

    @NotNull
    public List<File> getDefectPictureList(){
        return testReport.getDefectPictureList();
    }

}

@Data
@AllArgsConstructor
@NoArgsConstructor
class TestReport {

    @NotBlank(message = ParamFormatErrorConstant.DEFECT_EXPLAIN_CANNOT_BE_NULL)
    private String defectExplain;

    @NotBlank(message = ParamFormatErrorConstant.DEFECT_REPRODUCTION_STEP_CANNOT_BE_NULL)
    private String defectReproductionStep;

    @NotBlank(message = ParamFormatErrorConstant.TEST_EQUIPMENT_INFORMATION_CANNOT_BE_NULL)
    private String testEquipmentInformation;

    @NotNull(message = ParamFormatErrorConstant.DEFECT_PICTURE_LIST_CANNOT_BE_NULL)
    private List<File> defectPictureList;

    @NotBlank(message = ParamFormatErrorConstant.REPORT_NAME_CANNOT_BE_NULL)
    private String reportName;
}