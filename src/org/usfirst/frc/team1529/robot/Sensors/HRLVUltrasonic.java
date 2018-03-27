package org.usfirst.frc.team1529.robot.Sensors;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.SerialPort.Parity;
import edu.wpi.first.wpilibj.SerialPort.Port;
import edu.wpi.first.wpilibj.SerialPort.StopBits;

public class HRLVUltrasonic {
private SerialPort serialPort;
	public HRLVUltrasonic(){
		serialPort = new SerialPort(9600,Port.kOnboard, 8, Parity.kNone, StopBits.kOne);
	}
	public int GetRange(){
		
		
		return 0;
		
	}
}
