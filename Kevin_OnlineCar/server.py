# Import necessary libraries
from flask import Flask, render_template, request, Response  # Import Flask for web framework
import RPi.GPIO as GPIO  # Import RPi.GPIO for GPIO control
import cv2



# Create a Flask web application
app = Flask(__name__)

gst_str = (
    "v4l2src device=/dev/video0 ! "
    "videoconvert ! "
    "video/x-raw,format=BGR ! "
    "appsink"
)

# Set the GPIO mode and pin number
GPIO.setmode(GPIO.BCM)  # Set the GPIO pin numbering mode to BCM
forward = 17  # Define the GPIO pin number to which the LED is connected
backward= 27
left=23
right=24
GPIO.setup(forward, GPIO.OUT)  # Set the LED pin as an output pin
GPIO.setup(backward, GPIO.OUT)
GPIO.setup(left, GPIO.OUT)
GPIO.setup(right, GPIO.OUT)

def gen_frames():
    cap = cv2.VideoCapture(0)  # Use 0 for the default camera
    cap.set(3, 640)  # Width
    cap.set(4, 480)  # Height
    while True:
        success, frame = cap.read()
        if not success:
            print("Error reading frame")
            break
        else:
            ret, buffer = cv2.imencode('.jpg', frame)
            if not ret:
                print("Error encoding frame")
                break
            yield (b'--frame\r\n'
                   b'Content-Type: image/jpeg\r\n\r\n' + buffer.tobytes() + b'\r\n')

# Define routes
@app.route("/")
def index():
    return render_template("index.html")  # Render the HTML template for the main page


@app.route("/turn_on")
def turn_on():
    GPIO.output(forward, GPIO.HIGH)  # Turn on the LED by setting the pin to HIGH
    return "moving forward"  # Return a message indicating that the LED is turned on

@app.route("/left")
def dleft():
    GPIO.output(left, GPIO.HIGH)  # Turn on the LED by setting the pin to HIGH
    return "left"  # Return a message indicating that the LED is turned on

@app.route("/back")
def dback():
    GPIO.output(backward, GPIO.HIGH)  # Turn on the LED by setting the pin to HIGH
    return "back"  # Return a message indicating that the LED is turned on

@app.route("/right")
def dright():
    GPIO.output(right, GPIO.HIGH)  # Turn on the LED by setting the pin to HIGH
    return "right"  # Return a message indicating that the LED is turned on

@app.route('/video')
def video():
    return Response(gen_frames(), mimetype='multipart/x-mixed-replace; boundary=frame')


@app.route("/turn_off")
def turn_off():
    GPIO.output(forward, GPIO.LOW)  # Turn off the LED by setting the pin to LOW
    GPIO.output(backward, GPIO.LOW)
    GPIO.output(left, GPIO.LOW)
    GPIO.output(right, GPIO.LOW)
    return "LED turned off"  # Return a message indicating that the LED is turned off

# Start the Flask app
if __name__ == "__main__":
    app.run(debug=True, host='0.0.0.0')  # Run the Flask app with debugging enabled on all available network interfaces
