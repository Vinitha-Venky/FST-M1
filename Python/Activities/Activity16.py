class Car:

    def __init__(self, manufacturer, model, make, transmission, color):
        self.manufacturer = manufacturer
        self.model = model
        self.make = make
        self.transmission = transmission
        self.color = color

    def accelerate(self):
        print(self.manufacturer + " " +self.make+" "+self.transmission+" "+ self.model + " has started moving")

    def stop(self):
        print(self.manufacturer + " " +self.make+" "+self.transmission+" "+ self.model + " has stopped moving")

car1 = Car("Tata", "punch", "2023", "Manual", "White")
car2 = Car("Maruti", "800", "2013", "Manual", "Red")
car3 = Car("Suzuki", "Swift", "2017", "Automatic", "Black")

car1.accelerate()
car3.stop()
