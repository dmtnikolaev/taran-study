import cv2
import numpy as np
from matplotlib import pyplot as plt

def first_task():
    #Create images
    height = 400
    width = 800
    color = (255, 255, 255)
    pts = np.array([[0,0], [400, 0],[400, 400],
                    [0,400]],np.int32) 
    blank_image1 = np.zeros((height,width,3), np.uint8)
    blank_image1 = cv2.fillPoly(blank_image1, [pts], color)
    cv2.imshow("image1", blank_image1)

    pts = np.array([[240,200], [640, 200],[640, 250],
                    [240,250]],np.int32)
    blank_image2 = np.zeros((height,width,3), np.uint8)
    blank_image2 = cv2.fillPoly(blank_image2, [pts], color)
    cv2.imshow("image2", blank_image2)
    cv2.waitKey(0)

    # NOT
    cv2.imshow("not_image1", ~ blank_image1)
    # AND
    cv2.imshow("and_image", blank_image1 + blank_image2)
    # OR
    cv2.imshow("or_image",blank_image1*blank_image2)
    # XOR
    cv2.imshow("xor_image",blank_image1 ^ blank_image2)
    cv2.waitKey(0)



def second_task():

    image = cv2.imread("image2.jpg")
    cv2.imshow("image2", image)
    cv2.waitKey(0)
    # split
    b,g,r = cv2.split(image)
    # Displaying Blue channel image
    cv2.imshow("Model Blue Image", b)
    # Displaying Blue channel image
    cv2.imshow("Model Green Image", g)
    # Displaying Blue channel image
    cv2.imshow("Model Red Image", r)
    cv2.waitKey(0)


    # b_hist = cv2.calcHist(b,[0],None,[256],[0,256])
    # g_hist = cv2.calcHist(r, [1],None,[256],[0,256])
    # r_hist = cv2.calcHist(g, [2],None,[256],[0,256])

    # cv2.normalize(b_hist, b_hist, alpha=0, beta=255, norm_type=cv2.NORM_MINMAX)
    # cv2.normalize(g_hist, g_hist, alpha=0, beta=255, norm_type=cv2.NORM_MINMAX)
    # cv2.normalize(r_hist, r_hist, alpha=0, beta=255, norm_type=cv2.NORM_MINMAX)

    # hist_w = 512
    # hist_h = 400
    # histImage = np.zeros((hist_h, hist_w, 3), dtype=np.uint8)
    # bin_w = int(round( hist_w/256 ))

    # for i in range(1, 256):
    #     cv2.line(histImage, ( bin_w*(i-1), hist_h - int(b_hist[i-1]) ),
    #             ( bin_w*(i), hist_h - int(b_hist[i]) ),
    #             ( 255, 0, 0), thickness=2)
    #     cv2.line(histImage, ( bin_w*(i-1), hist_h - int(g_hist[i-1]) ),
    #             ( bin_w*(i), hist_h - int(g_hist[i]) ),
    #             ( 0, 255, 0), thickness=2)
    #     cv2.line(histImage, ( bin_w*(i-1), hist_h - int(r_hist[i-1]) ),
    #             ( bin_w*(i), hist_h - int(r_hist[i]) ),
    #             ( 0, 0, 255), thickness=2)
    # cv2.imshow('Source image', image)
    # cv2.imshow('calcHist Demo', histImage)
    # cv2.waitKey(0)

    # cv2.waitKey(0)
        # histograms
    colors = ('b','g','r')
  
    # compute and plot the image histograms
    for i,color in enumerate(colors):
        hist = cv2.calcHist([image],[i],None,[256],[0,256])
        plt.plot(hist,color = color)
    plt.title('Image Histogram GFG')
    plt.show()
    # normalize
    norm_image = cv2.normalize(image, image, alpha=0, beta=255, norm_type=cv2.NORM_MINMAX)
    cv2.imshow("norm_image", norm_image)
    cv2.waitKey(0)
def third_task():
    image = cv2.imread("image3.jpg")
    cv2.imshow("image3", image)
    image_grey = cv2.cvtColor(image, cv2.COLOR_BGR2GRAY)
    cv2.imshow("image_grey", image_grey)
    equ = cv2.equalizeHist(image_grey)
    cv2.imshow("image_grey_equalize", equ)
    cv2.waitKey(0)

def main():
    first_task()
    second_task()
    third_task()

if __name__ == "__main__":
    main()