package ua.dlubovskyi.hms.dto.create;

public class CreateDoctorDto {

    private CreateUserDto createUserDto;
    private String specializationName;

    public void setCreateUserDto(CreateUserDto createUserDto) {
        this.createUserDto = createUserDto;
    }

    public CreateUserDto getCreateUserDto() {
        return createUserDto;
    }

    public String getSpecializationName() {
        return specializationName;
    }

    public void setSpecializationName(String specializationName) {
        this.specializationName = specializationName;
    }

}
