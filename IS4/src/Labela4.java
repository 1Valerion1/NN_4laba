public class Labela4 {
	 public static void main(String args[]) {
		 System.out.println("�������� ��� �������������� �������� � �������");
		 // ������ �� ������� ��������� ���� ��������� ����(�������)
		 double[] Degrees = { 1,7,13,15,28,45 };                      // ������ � �������� �
		 double[] Radians = { 0.0174533,0.122173,0.226893,0.261799,0.488692,0.785398 };//  ����������� � �������
		 
		 NeuralNetwork n = new NeuralNetwork();
		   int r = (int) (Math.random()*6);//�������� ����� �� �������� � �� ���� ���������
		   int i = 0;
		   while ((n.Error > n.speed)||(n.Error < -n.speed))
		    {
		        i++;
		        n.NeuronTraining(Degrees[r], Radians[r]);
		        if (i % 10000000 == 0)       // 
		        {
		        	 System.out.println("Error number: "+i+" Radians:"+ n.Error);
		        }
		    }
		 
		 // System.out.println("\n");
		    n.ResultCalcNeurons(15);
		    n.ReverseOutput(1);
		    n.ResultCalcNeurons(40);
		    n.ReverseOutput(50);
		    n.ResultCalcNeurons(3);
		    n.ReverseOutput(356);
		 }
	}
	class NeuralNetwork{
		public
		double weight = Math.random() * 3; //����������
		double Error=-0.0001;//
		double speed=0.00000001;//  �������� �������� �������
		double result;

		 public void ResultCalcNeurons(double input)//����� �������� � ����������� ������� �������(�������->�������)
		{
			 System.out.println((int)input+" degress eqals: "+input*weight+" radians");
		}
		 
		public void ReverseOutput(double output)//�������� ����� �� ������->�������(�����/���)
		{
			System.out.println((int)output+" radians equals "+output/weight+" degrees");
		}
		 
		public void NeuronTraining(double input, double output)//����������(�������/�������)
		{
			double InterResult,correct;//��������� �� ������ ������ � ������ ������ �������������
			
			InterResult= input*weight;
			Error= output-InterResult;//������ ������
			correct=(Error/InterResult)*speed;
			weight=weight+correct;// ��������� ���� �� ������ �������������
		}
	}

