package com.umitems;

/**
 * Created by um2015 on 7/6/2015.
 */
public class CollatzConjectureLength {

  final static long[] PRE_PROCESS = {1, 2, 8, 3, 6, 9, 17, 4, 20, 7, 15, 10, 10, 18, 18, 5, 13, 21, 21, 8, 8, 16, 16, 11, 24, 11, 112, 19, 19, 19, 107, 6, 27, 14, 14, 22, 22, 22, 35, 9, 110, 9, 30, 17, 17, 17, 105, 12, 25, 25, 25, 12, 12, 113, 113, 20, 33, 20, 33, 20, 20, 108, 108, 7, 28, 28, 28, 15, 15, 15, 103, 23, 116, 23, 15, 23, 23, 36, 36, 10, 23, 111, 111, 10, 10, 31, 31, 18, 31, 18, 93, 18, 18, 106, 106, 13, 119, 26, 26, 26, 26, 26, 88, 13, 39, 13, 101, 114, 114, 114, 70, 21, 13, 34, 34, 21, 21, 34, 34, 21, 96, 21, 47, 109, 109, 109, 47, 8, 122, 29, 29, 29, 29, 29, 42, 16, 91, 16, 42, 16, 16, 104, 104, 24, 117, 117, 117, 24, 24, 16, 16, 24, 37, 24, 86, 37, 37, 37, 55, 11, 99, 24, 24, 112, 112, 112, 68, 11, 50, 11, 125, 32, 32, 32, 81, 19, 32, 32, 32, 19, 19, 94, 94, 19, 45, 19, 45, 107, 107, 107, 45, 14, 120, 120, 120, 27, 27, 27, 120, 27, 19, 27, 40, 27, 27, 89, 89, 14, 40, 40, 40, 14, 14, 102, 102, 115, 27, 115, 53, 115, 115, 71, 71, 22, 53, 14, 14, 35, 35, 35, 128, 22, 84, 22, 128, 35, 35, 35, 53, 22, 22, 97, 97, 22, 22, 48, 48, 110, 48, 110, 66, 110, 110, 48, 48, 9, 123, 123, 123, 30, 30, 30, 79, 30, 123, 30, 22, 30, 30, 43, 43, 17, 30, 92, 92, 17, 17, 43, 43, 17, 43, 17, 61, 105, 105, 105, 43, 25, 30, 118, 118, 118, 118, 118, 56, 25, 74, 25, 118, 17, 17, 17, 43, 25, 38, 38, 38, 25, 25, 87, 87, 38, 131, 38, 38, 38, 38, 56, 56, 12, 25, 100, 100, 25, 25, 25, 144, 113, 51, 113, 25, 113, 113, 69, 69, 12, 113, 51, 51, 12, 12, 126, 126, 33, 126, 33, 126, 33, 33, 82, 82, 20, 126, 33, 33, 33, 33, 33, 51, 20, 46, 20, 46, 95, 95, 95, 46, 20, 20, 46, 46, 20, 20, 46, 46, 108, 64, 108, 59, 108, 108, 46, 46, 15, 33, 121, 121, 121, 121, 121, 121, 28, 59, 28, 77, 28, 28, 121, 121, 28, 20, 20, 20, 28, 28, 41, 41, 28, 41, 28, 134, 90, 90, 90, 134, 15, 134, 41, 41, 41, 41, 41, 33, 15, 59, 15, 54, 103, 103, 103, 41, 116, 28, 28, 28, 116, 116, 54, 54, 116, 28, 116, 54, 72, 72, 72, 98, 23, 116, 54, 54, 15, 15, 15, 41, 36, 129, 36, 129, 36, 36, 129, 129, 23, 36, 85, 85, 23, 23, 129, 129, 36, 36, 36, 28, 36, 36, 54, 54, 23, 49, 23, 23, 98, 98, 98, 142, 23, 49, 23, 142, 49, 49, 49, 98, 111, 23, 49, 49, 111, 111, 67, 67, 111, 62, 111, 36, 49, 49, 49, 62, 10, 36, 124, 124, 124, 124, 124, 62, 31, 124, 31, 124, 31, 31, 80, 80, 31, 31, 124, 124, 31, 31, 23, 23, 31, 23, 31, 49, 44, 44, 44, 137, 18, 44, 31, 31, 93, 93, 93, 44, 18, 137, 18, 31, 44, 44, 44, 88, 18, 44, 44, 44, 18, 18, 62, 62, 106, 57, 106, 31, 106, 106, 44, 44, 26, 31, 31, 31, 119, 119, 119, 31, 119, 57, 119, 119, 119, 119, 57, 57, 26, 75, 75, 75, 26, 26, 119, 119, 18, 57, 18, 70, 18, 18, 44, 44, 26, 132, 39, 39, 39, 39, 39, 70, 26, 132, 26, 132, 88, 88, 88, 132, 39, 26, 132, 132, 39, 39, 39, 39, 39, 31, 39, 31, 57, 57, 57, 132, 13, 52, 26, 26, 101, 101, 101, 39, 26, 145, 26, 101, 26, 26, 145, 145, 114, 52, 52, 52, 114, 114, 26, 26, 114, 52, 114, 145, 70, 70, 70, 96, 13, 65, 114, 114, 52, 52, 52, 65, 13, 65, 13, 39, 127, 127, 127, 39, 34, 127, 127, 127, 34, 34, 127, 127, 34, 127, 34, 65, 83, 83, 83, 171, 21, 34, 127, 127, 34, 34, 34, 65, 34, 26, 34, 26, 34, 34, 52, 52, 21, 47, 47, 47, 21, 21, 47, 47, 96, 34, 96, 140, 96, 96, 47, 47, 21, 140, 21, 21, 47, 47, 47, 96, 21, 91, 21, 47, 47, 47, 47, 140, 109, 21, 65, 65, 109, 109, 60, 60, 109, 34, 109, 153, 47, 47, 47, 60, 16, 34, 34, 34, 122, 122, 122, 153, 122, 34, 122, 60, 122, 122, 122, 122, 29, 122, 60, 60, 29, 29, 78, 78, 29, 78, 29, 104, 122, 122, 122, 73, 29, 60, 21, 21, 21, 21, 21, 73, 29, 47, 29, 135, 42, 42, 42, 135, 29, 42, 42, 42, 29, 29, 135, 135, 91, 135, 91, 42, 91, 91, 135, 135, 16, 29, 135, 135, 42, 42, 42, 86, 42, 42, 42, 42, 42, 42, 34, 34, 16, 60, 60, 60, 16, 16, 55, 55, 104, 29, 104, 148, 104, 104, 42, 42, 117, 148, 29, 29, 29, 29, 29, 179, 117, 148, 117, 29, 55, 55, 55, 148, 117, 117, 29, 29, 117, 117, 55, 55, 73, 148, 73, 47, 73, 73, 99, 99, 24, 68, 117, 117, 55, 55, 55, 117, 16, 68, 16, 55, 16, 16, 42, 42, 37, 130, 130, 130, 37, 37, 130, 130, 37, 130, 37, 68, 130, 130, 130, 117, 24, 130, 37, 37, 86, 86, 86, 130, 24, 174, 24, 86, 130, 130, 130, 37, 37, 37, 37, 37, 37, 37, 29, 29, 37, 29, 37, 29, 55, 55, 55, 130, 24, 50, 50, 50, 24, 24, 24, 143, 99, 50, 99, 37, 99, 99, 143, 143, 24, 99, 50, 50, 24, 24, 143, 143, 50, 24, 50, 37, 50, 50, 99, 99, 112, 94, 24, 24, 50, 50, 50, 50, 112, 143, 112, 42, 68, 68, 68, 94, 112, 112, 63, 63, 112, 112, 37, 37, 50, 156, 50, 63, 50, 50, 63, 63, 11, 37, 37, 37, 125, 125, 125, 37, 125, 156, 125, 125, 125, 125, 63, 63, 32, 125, 125, 125, 32, 32, 125, 125, 32, 63, 32, 94, 81, 81, 81, 169, 32, 81, 32, 32, 125, 125, 125, 76, 32, 76, 32, 63, 24, 24, 24, 169, 32, 24, 24, 24, 32, 32, 50, 50, 45, 138, 45, 138, 45, 45, 138, 138, 19, 45, 45, 45, 32, 32, 32, 76, 94, 138, 94, 32, 94, 94, 45, 45, 19, 94, 138, 138, 19, 19, 32, 32, 45, 138, 45, 94, 45, 45, 89, 89, 19, 45, 45, 45, 45, 45, 45, 138, 19, 37, 19, 37, 63, 63, 63, 63, 107, 19, 58, 58, 107, 107, 32, 32, 107, 151, 107, 58, 45, 45, 45, 58, 27, 151, 32, 32, 32, 32, 32, 58, 120, 182, 120, 151, 120, 120, 32, 32, 120, 58, 58, 58, 120, 120, 120, 120, 120, 32, 120, 58, 58, 58, 58, 89, 27, 151, 76, 76, 76, 76, 76, 50, 27, 102, 27, 120, 120, 120, 120, 71, 19, 58, 58, 58, 19, 19, 71, 71, 19, 58, 19, 71, 45, 45, 45, 164, 27, 133, 133, 133, 40, 40, 40, 133, 40, 133, 40, 133, 40, 40, 71, 71, 27, 133, 133, 133, 27, 27, 133, 133, 89, 40, 89, 71, 89, 89, 133, 133, 40, 177, 27, 27, 133, 133, 133, 89, 40, 40, 40, 84, 40, 40, 40, 177, 40, 40, 32, 32, 40, 40, 32, 32, 58, 32, 58, 84, 58, 58, 133, 133, 14, 53, 53, 53, 27, 27, 27, 146, 102, 146, 102, 53, 102, 102, 40, 40, 27, 102, 146, 146, 27, 27, 102, 102, 27, 53, 27, 177, 146, 146, 146, 102, 115, 27, 53, 53, 53, 53, 53, 146, 115, 102, 115, 53, 27, 27, 27, 53, 115, 53, 53, 53, 115, 115, 146, 146, 71, 45, 71, 27, 71, 71, 97, 97, 14, 115, 66, 66, 115, 115, 115, 159, 53, 40, 53, 115, 53, 53, 66, 66, 14, 53, 66, 66, 14, 14, 40, 40, 128, 40, 128, 115, 128, 128, 40, 40, 35, 159, 128, 128, 128, 128, 128, 97, 35, 66, 35, 66, 128, 128, 128, 115, 35, 35, 128, 128, 35, 35, 66, 66, 84, 97, 84, 128, 84, 84, 172, 172, 22, 84, 35, 35, 128, 128, 128, 35, 35, 79, 35, 128, 35, 35, 66, 66, 35, 27, 27, 27, 35, 35, 27, 27, 35, 27, 35, 79, 53, 53, 53, 128, 22, 141, 48, 48, 48, 48, 48, 53, 22, 141, 22, 141, 48, 48, 48, 141, 97, 35, 35, 35, 97, 97, 141, 141, 97, 35, 97, 141, 48, 48, 48, 172, 22, 97, 141, 141, 22, 22, 22, 97, 48, 35, 48, 141, 48, 48, 97, 97, 22, 48, 92, 92, 22, 22, 48, 48, 48, 48, 48, 48, 48, 48, 141, 141, 110, 40, 22, 22, 66, 66, 66, 92, 110, 66, 110, 141, 61, 61, 61, 154, 110, 110, 35, 35, 110, 110, 154, 154, 48, 61, 48, 61, 48, 48, 61, 61, 17, 154, 35, 35, 35, 35, 35, 110, 123, 61, 123, 35, 123, 123, 154, 154, 123, 123, 35, 35, 123, 123, 61, 61, 123, 61, 123, 154, 123, 123, 123, 61, 30, 35, 123, 123, 61, 61, 61, 61, 30, 92, 30, 123, 79, 79, 79, 167, 30, 79, 79, 79, 30, 30, 105, 105, 123, 123, 123, 74, 123, 123, 74, 74, 30, 61, 61, 61, 22, 22, 22, 167, 22, 74, 22, 22, 22, 22, 74, 74, 30, 48, 48, 48, 30, 30, 136, 136, 43, 136, 43, 74, 43, 43, 136, 136, 30, 136, 43, 43, 43, 43, 43, 105, 30, 74, 30, 74, 136, 136, 136, 136, 92, 30, 136, 136, 92, 92, 43, 43, 92, 74, 92, 43, 136, 136, 136, 74, 17, 180, 30, 30, 136, 136, 136, 43, 43, 92, 43, 136, 43, 43, 87, 87, 43, 43, 43, 43, 43, 43, 43, 43, 43, 35, 43, 136, 35, 35, 35, 180, 17, 35, 61, 61, 61, 61, 61, 61, 17, 136, 17, 149, 56, 56, 56, 149, 105, 30, 30, 30, 105, 105, 149, 149, 105, 56, 105, 56, 43, 43, 43, 56, 118, 105, 149, 149, 30, 30, 30, 105, 30, 105, 30, 56, 30, 30, 180, 180, 118, 149, 149, 149, 118, 118, 30, 30, 56, 56, 56, 43, 56, 56, 149, 149, 118, 105, 118, 118, 30, 30, 30, 149, 118, 56, 118, 56, 56, 56, 56, 87, 74, 118, 149, 149, 74, 74, 48, 48, 74, 30, 74, 48, 100, 100, 100, 100, 25, 118, 69, 69, 118, 118, 118, 69, 56, 162, 56, 43, 56, 56, 118, 118, 17, 56, 69, 69, 17, 17, 56, 56, 17, 69, 17, 162, 43, 43, 43, 162, 38, 43, 131, 131, 131, 131, 131, 69, 38, 43, 38, 131, 131, 131, 131, 162, 38, 131, 131, 131, 38, 38, 69, 69, 131, 69, 131, 131, 131, 131, 118, 118, 25, 38, 131, 131, 38, 38, 38, 69, 87, 69, 87, 38, 87, 87, 131, 131, 25, 87, 175, 175, 25, 25, 87, 87, 131, 38, 131, 87, 131, 131, 38, 38, 38, 82, 38, 38, 38, 38, 38, 175, 38, 69, 38, 69, 30, 30, 30, 131, 38, 38, 30, 30, 38, 38, 30, 30, 56, 82, 56, 175, 56, 56, 131, 131, 25, 144, 51, 51, 51, 51, 51, 51, 25, 56, 25, 144, 25, 25, 144, 144, 100, 51, 51, 51, 100, 100, 38, 38, 100, 38, 100, 82, 144, 144, 144, 175, 25, 38, 100, 100, 51, 51, 51, 82, 25, 175, 25, 82, 144, 144, 144, 100, 51, 25, 25, 25, 51, 51, 38, 38, 51, 144, 51, 144, 100, 100, 100, 51, 113, 51, 95, 95, 25, 25, 25, 51, 51, 51, 51, 51, 51, 51, 51, 51, 113, 51, 144, 144, 113, 113, 43, 43, 69, 25, 69, 43, 69, 69, 95, 95, 113, 69, 113, 113, 64, 64, 64, 157, 113, 157, 113, 157, 38, 38, 38, 64, 51, 113, 157, 157, 51, 51, 64, 64, 51, 64, 51, 157, 64, 64, 64, 157, 12, 157, 38, 38, 38, 38, 38, 38, 126, 113, 126, 38, 126, 126, 38, 38, 126, 126, 157, 157, 126, 126, 126, 126, 126, 38, 126, 95, 64, 64, 64, 51, 33, 64, 126, 126, 126, 126, 126, 113, 33, 64, 33, 38, 126, 126, 126, 108, 33, 64, 64, 64, 33, 33, 95, 95, 82, 126, 82, 157, 82, 82, 170, 170, 33, 82, 82, 82, 33, 33, 33, 82, 126, 108, 126, 33, 126, 126, 77, 77, 33, 126, 77, 77, 33, 33, 64, 64, 25, 64, 25, 77, 25, 25, 170, 170, 33, 77, 25, 25, 25, 25, 25, 108, 33, 77, 33, 170, 51, 51, 51, 126, 46, 33, 139, 139, 46, 46, 139, 139, 46, 77, 46, 51, 139, 139, 139, 77, 20, 139, 46, 46, 46, 46, 46, 139, 33, 108, 33, 77, 33, 33, 77, 77, 95, 139, 139, 139, 95, 95, 33, 33, 95, 139, 95, 51, 46, 46, 46, 170, 20, 77, 95, 95, 139, 139, 139, 121, 20, 77, 20, 95, 33, 33, 33, 183, 46, 139, 139, 139, 46, 46, 95, 95, 46, 139, 46, 46, 90, 90, 90, 139, 20, 46, 46, 46, 46, 46, 46, 77, 46, 46, 46, 38, 46, 46, 139, 139, 20, 38, 38, 38, 20, 20, 38, 38, 64, 64, 64, 90, 64, 64, 64, 64, 108, 139, 20, 20, 59, 59, 59, 152, 108, 152, 108, 59, 33, 33, 33, 121, 108, 108, 152, 152, 108, 108, 59, 59, 46, 59, 46, 152, 46, 46, 59, 59, 28, 108, 152, 152, 33, 33, 33, 152, 33, 108, 33, 108, 33, 33, 59, 59, 121, 33, 183, 183, 121, 121, 152, 152, 121, 152, 121, 108, 33, 33, 33, 90, 121, 59, 59, 59, 59, 59, 59, 152, 121, 152, 121, 108, 121, 121, 121, 59, 121, 33, 33, 33, 121, 121, 59, 59, 59, 59, 59, 59, 59, 59, 90, 90, 28, 121, 152, 152, 77, 77, 77, 165, 77, 51, 77, 77, 77, 77, 51, 51, 28, 103, 103, 103, 28, 28, 121, 121, 121, 72, 121, 33, 121, 121, 72, 72, 20, 165, 59, 59, 59, 59, 59, 72, 20, 121, 20, 165, 72, 72, 72, 121, 20, 20, 59, 59, 20, 20, 72, 72, 46, 165, 46, 121, 46, 46, 165, 165, 28, 46, 134, 134, 134, 134, 134, 134, 41, 72, 41, 46, 41, 41, 134, 134, 41, 134, 134, 134, 41, 41, 134, 134, 41, 134, 41, 103, 72, 72, 72, 209, 28, 72, 134, 134, 134, 134, 134, 134, 28, 121, 28, 72, 134, 134, 134, 46, 90, 41, 41, 41, 90, 90, 72, 72, 90, 41, 90, 103, 134, 134, 134, 72, 41, 90, 178, 178, 28, 28, 28, 64, 134, 90, 134, 41, 134, 134, 90, 90, 41, 134, 41, 41, 41, 41, 85, 85, 41, 41, 41, 134, 41, 41, 178, 178, 41, 72, 41, 41, 33, 33, 33, 85, 41, 134, 41, 178, 33, 33, 33, 178, 59, 41, 33, 33, 59, 59, 85, 85, 59, 178, 59, 59, 134, 134, 134, 116, 15, 147, 54, 54, 54, 54, 54, 147, 28, 54, 28, 54, 28, 28, 147, 147, 103, 28, 147, 147, 103, 103, 54, 54, 103, 54, 103, 147, 41, 41, 41, 54, 28, 41, 103, 103, 147, 147, 147, 147, 28, 178, 28, 103, 103, 103, 103, 85, 28, 54, 54, 54, 28, 28, 178, 178, 147, 85, 147, 103, 147, 147, 103, 103, 116, 28, 28, 28, 54, 54, 54, 191, 54, 41, 54, 54, 54, 54, 147, 147, 116, 103, 103, 103, 116, 116, 54, 54, 28, 98, 28, 147, 28, 28, 54, 54, 116, 54, 54, 54, 54, 54, 54, 85, 116, 54, 116, 46, 147, 147, 147, 46, 72, 116, 46, 46, 72, 72, 28, 28, 72, 46, 72, 72, 98, 98, 98, 98, 15, 72, 116, 116, 67, 67, 67, 28, 116, 160, 116, 67, 116, 116, 160, 160, 54, 41, 41, 41, 54, 54, 116, 116, 54, 160, 54, 98, 67, 67, 67, 67, 15, 67, 54, 54, 67, 67, 67, 129, 15, 160, 15, 116, 41, 41, 41, 160, 129, 41, 41, 41, 129, 129, 116, 116, 129, 41, 129, 67, 41, 41, 41, 173, 36, 129, 160, 160, 129, 129, 129, 160, 129, 129, 129, 41, 129, 129, 98, 98, 36, 67, 67, 67, 36, 36, 67, 67, 129, 129, 129, 160, 129, 129, 116, 116, 36, 67, 36, 36, 129, 129, 129, 67, 36, 111, 36, 67, 67, 67, 67, 67, 85, 36, 98, 98, 85, 85, 129, 129, 85, 160, 85, 59, 173, 173, 173, 160, 23, 85, 85, 85, 36, 36, 36, 59, 129, 85, 129, 111, 129, 129, 36, 36, 36, 129, 80, 80, 36, 36, 129, 129, 36, 80, 36, 173, 67, 67, 67, 173, 36, 67, 28, 28, 28, 28, 28, 129, 36, 173, 36, 80, 28, 28, 28, 80, 36, 28, 28, 28, 36, 36, 80, 80, 54, 173, 54, 54, 54, 54, 129, 129, 23, 36, 142, 142, 49, 49, 49, 129, 49, 142, 49, 49, 49, 49, 54, 54, 23, 142, 142, 142, 23, 23, 142, 142, 49, 49, 49, 142, 49, 49, 142, 142, 98, 111, 36, 36, 36, 36, 36, 217, 98, 80, 98, 142, 142, 142, 142, 173, 98, 98, 36, 36, 98, 98, 142, 142, 49, 54, 49, 80, 49, 49, 173, 173, 23, 80, 98, 98, 142, 142, 142, 98, 23, 124, 23, 142, 23, 23, 98, 98, 49, 36, 36, 36, 49, 49, 142, 142, 49, 142, 49, 49, 98, 98, 98, 49, 23, 142, 49, 49, 93, 93, 93, 142, 23, 142, 23, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49, 49};

  public static void genCollatz() {
    // this method use to gen the first elems to reduce the runtime
    final int MAX_NUM = 3000;
    long[] myList = new long[MAX_NUM];

    System.out.print("1");
    for (int index = 2; index < MAX_NUM; index++) {
      myList[index] = conjecture(index);
      //System.out.println(index+"\t"+myList[index]);

      System.out.print("," + myList[index]);
    }

  }

  public static long conjecture(long x) {
    long count = 0;

    while (x > 2998) {
      if (x % 2 == 0)
        x /= 2;
      else
        x = x * 3 + 1;
      count++;
    }

    return PRE_PROCESS[(int) x - 1] + count;
  }
}
