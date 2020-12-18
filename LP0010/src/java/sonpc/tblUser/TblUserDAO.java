/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sonpc.tblUser;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;
import sonpc.tblUser.TblUserDTO;
import sonpc.utils.DBHelpers;

/**
 *
 * @author ACER
 */
public class TblUserDAO implements Serializable{
    
    public TblUserDTO checkLogin(String userID, String password) throws NamingException, SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con = DBHelpers.makeConnection();
            if (con != null){
                String sql = "Select fullName, isAdmin From tbl_User Where userID = ? And password = ?";
                ps = con.prepareStatement(sql);
                ps.setString(1, userID);
                ps.setString(2, password);
                rs = ps.executeQuery();
                if (rs.next()){
                    String fullName = rs.getString("fullName");
                    boolean role = rs.getBoolean("isAdmin");
                    TblUserDTO dto = new TblUserDTO(userID, password, fullName, role);
                    return dto;
                }
            }
        }
        finally{
            if (rs != null){
                rs.close();
            }
            if (ps != null){
                ps.close();
            }
            if (con != null){
                con.close();
            }
        }
        return null;
    }
    
    public boolean checkIsMember(TblUserDTO dto) throws NamingException, SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            con = DBHelpers.makeConnection();
            if (con != null){
                String sql = "Select fullName From tbl_User Where userID = ? And password = ? And isAdmin = 0";
                ps = con.prepareStatement(sql);
                ps.setString(1, dto.getUserID());
                ps.setString(2, dto.getPassword());
                rs = ps.executeQuery();
                if (rs.next()){
                    
                }
            }
        }
        finally{
            if (rs != null){
                rs.close();
            }
            if (ps != null){
                ps.close();
            }
            if (con != null){
                con.close();
            }
        }
        return false;
    }
}
