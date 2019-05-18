package ua.dlubovskyi.hms.dto.create;

public class CreatePatientDto {

    private CreateUserDto createUserDto;
    private String doctorId;

    public CreateUserDto getCreateUserDto() {
        return createUserDto;
    }

    public void setCreateUserDto(CreateUserDto createUserDto) {
        this.createUserDto = createUserDto;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }
}
