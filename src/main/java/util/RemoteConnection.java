package util;

public class RemoteConnection {
	public static void main(String[] arg) {
		/*try {
			JSch jsch = new JSch();

			String host = null;
			if (arg.length > 0) {
				host = arg[0];
			} else {
				host = "inguat@172.16.19.18"; // enter username and ipaddress for machine you need to connect
			}
			String user = host.substring(0, host.indexOf('@'));
			host = host.substring(host.indexOf('@') + 1);

			Session session = jsch.getSession(user, host, 22);

			// username and password will be given via UserInfo interface.
			UserInfo ui = new MyUserInfo();
			session.setUserInfo(ui);
			session.connect();

			String command = "ls"; // enter any command you need to execute

			int index = 0;
			
			ChannelExec channelExec = (ChannelExec) session.openChannel("exec");
			In
			
			
			
			Channel channel = session.openChannel("exec");
			((ChannelExec) channel).setCommand(command);

			channel.setInputStream(null);

			((ChannelExec) channel).setErrStream(System.err);

			InputStream in = channel.getInputStream();

			channel.connect();

			
			 * Channel channel=session.openChannel("exec");
			 * ((ChannelExec)channel).setCommand("cd ../ && pwd && ls");
			 * channel.connect(); channel.run();
			 

			
			 * byte[] tmp=new byte[1024]; while(true){ while(in.available()>0){
			 * int i=in.read(tmp, 0, 1024); if(i<0)break; System.out.print(new
			 * String(tmp, 0, i)); } if(channel.isClosed()){
			 * System.out.println("exit-status: "+channel.getExitStatus());
			 * break; } try{}catch(Exception ee){} }
			 
			channel.disconnect();
			session.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static class MyUserInfo implements UserInfo {
		public String getPassword() {
			return passwd;
		}

		public boolean promptYesNo(String str) {
			str = "Yes";
			return true;
		}

		String passwd;

		public String getPassphrase() {
			return null;
		}

		public boolean promptPassphrase(String message) {
			return true;
		}

		public boolean promptPassword(String message) {
			passwd = "!ngLife@2018"; // enter the password for the machine you want to connect.
			return true;
		}

		public void showMessage(String message) {

		}
	}*/
	}
}