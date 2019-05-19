package ua.dlubovskyi.hms.dto.create;

public class CreatePatientDto {

    private CreateUserDto createUserDto;

    public CreateUserDto getCreateUserDto() {
        return createUserDto;
    }

    public void setCreateUserDto(CreateUserDto createUserDto) {
        this.createUserDto = createUserDto;
    }

}
