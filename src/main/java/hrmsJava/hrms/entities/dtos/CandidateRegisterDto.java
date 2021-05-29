package hrmsJava.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CandidateRegisterDto {
private String firstName;
private String lastName;
private String nationalIdentity;
private String birthdate;
private String email;
private String password;
private String passwordRepeat;
}
