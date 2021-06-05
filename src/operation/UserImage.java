package operation;

import java.util.ArrayList;

import dao.UserDao;
import dao.UserdataDao;
import entity.Image;
import entity.Userdata;

public class UserImage {
	public static ArrayList<Image> getUserImage() {
		ArrayList<String> emaillist = UserDao.selectEmail();
		ArrayList<Image> images = new ArrayList<Image>();
		for (String i : emaillist) {

			Userdata ud = UserdataDao.selectByMaxGrade(i);
			if (ud != null) {
				String brand = ud.getBrand();
				System.out.println(brand);
				Image image = new Image(i, brand);
				images.add(image);
			} else {
				Image image = new Image(i, "нч ");
				images.add(image);
			}

		}
		return images;
	}
}