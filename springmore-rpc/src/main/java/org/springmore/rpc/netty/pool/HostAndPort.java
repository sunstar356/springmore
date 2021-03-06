package org.springmore.rpc.netty.pool;

/**
 * HostAndPort
 * @author 唐延波
 * @date 2015年7月18日
 */
public class HostAndPort {
	public static final String LOCALHOST_STR = "localhost";

	private String host;
	private int port;

	public HostAndPort(String host, int port) {
		this.host = host;
		this.port = port;
	}

	public String host() {
		return host;
	}

	public int port() {
		return port;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof HostAndPort) {
			HostAndPort hp = (HostAndPort) obj;

			String thisHost = convertHost(host);
			String hpHost = convertHost(hp.host);
			return port == hp.port && thisHost.equals(hpHost);

		}

		return false;
	}

	@Override
	public String toString() {
		return host + ":" + port;
	}

	private String convertHost(String host) {
		if (host.equals("127.0.0.1"))
			return LOCALHOST_STR;
		else if (host.equals("::1"))
			return LOCALHOST_STR;

		return host;
	}
}
