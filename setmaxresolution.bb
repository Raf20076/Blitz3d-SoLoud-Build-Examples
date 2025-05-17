;Tested on Blitz3D-V1.118 SoLoud Build (FMOD dependency removed) 
;Windows 7 32 bit

;SoLoud is an easy to use, free, portable c/c++ audio engine for games.
;https://github.com/jarikomppa/soloud

;Blitz3d SoLoud Build
;sourcecode
;https://github.com/blitz-research/blitz3d_soloud
;releases Blitz3D SoLoad V1.117
;https://github.com/blitz-research/blitz3d_soloud/tags
;releases Blitz3D SoLoad V1.118
;https://blitzresearch.itch.io/blitz3d/devlog/793622/blitz3d-v1118-now-available   (Date of release Sep 04, 2024)



;Function sets the highest resolution with the highest color depth
;Code written with ChatGPT help
;To run function in fullscreen mode use 
;SetMaxResolution(True)

Function SetMaxResolution(fullscreen = True)
	
maxWidth = 0
maxHeight = 0
maxDepth = 0

;Loop through all available graphic modes 
For i =1 To CountGfxModes3D() 
	width = GfxModeWidth(i)
	height = GfxModeHeight(i)
	depth = GfxModeDepth(i)
	
;Prefer higher color depth, then highest resolution within the depth
	If depth > maxDepth Or (depth = maxDepth And width * height > maxWidth * maxHeight)
			maxDepth = depth
			maxWidth = width
			maxHeight = height
		EndIf
Next

mode = 1 ; fullscreen

If fullscreen = False Then mode = 2 ;windowed

;Apply graphic settings
Graphics3D maxWidth, maxHeight, maxDepth, mode ;Set graphic mode with the chosen resolution

SetBuffer BackBuffer()

;Test
While Not KeyHit(1)
	Cls
	Color 255, 255, 255
	Text 20,20, "Resolution: " + width + "x" + height + "x" + depth
	Flip
Wend
End
End Function

;to check how it works uncomment below SetMaxResolution(True)
;SetMaxResolution(True)

