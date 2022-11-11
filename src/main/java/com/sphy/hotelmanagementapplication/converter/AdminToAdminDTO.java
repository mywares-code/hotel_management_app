package com.sphy.hotelmanagementapplication.converter;

import com.sphy.hotelmanagementapplication.domain.Admin;
import com.sphy.hotelmanagementapplication.domain.Hotel;
import com.sphy.hotelmanagementapplication.dto.AdminDTO;
import org.springframework.stereotype.Component;

/***
 * created by gp
 */
@Component
public class AdminToAdminDTO {

    private final HotelToHotelDTO hotelToHotelDTO;

    public AdminToAdminDTO(HotelToHotelDTO hotelToHotelDTO) {
        this.hotelToHotelDTO = hotelToHotelDTO;
    }

    /***
     * converts an Admin Object to AdminDTO
     * @param admin Admin object we want to convert
     * @return the converted AdminDTO object
     * @throws Exception
     */
    public AdminDTO converter(Admin admin) throws Exception {

        AdminDTO adminDTO = new AdminDTO();

        adminDTO.setId(admin.getId());
        adminDTO.setFirstname(admin.getFirstname());
        adminDTO.setLastname(admin.getLastname());
        adminDTO.setUsername(admin.getUsername());
        adminDTO.setEmail(admin.getEmail());
        adminDTO.setEmailVerify(admin.isEmailVerify());
        adminDTO.setHashedPassword(admin.getHashedPassword());
        adminDTO.setTransactionId(admin.getTransactionId());

        for (Hotel hotel : admin.getHotels()){
            adminDTO.getHotels().add(hotelToHotelDTO.converter(hotel));
        }

        return adminDTO;
    }
}