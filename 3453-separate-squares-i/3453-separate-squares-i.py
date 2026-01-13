class Solution:
    def separateSquares(self, squares: List[List[int]]) -> float:
        
        
        bottom, top = 0, pow(10, 10)
        
        
        def count(point):
            top = 0
            bottom = 0
            
            for xi, yi, l in squares:
                size = l * l 
                
                bottom += size 
                top += size 
                
                b_left = point - (yi + l)
                t_left = yi - point
                
                if b_left < 0:
                    bottom -= min(l * l, abs(b_left) * l)
                    
                if t_left < 0:
                    top -= min(l *l, abs(t_left) * l)
            return top - bottom
                    
                    
                
                
            return top - bottom
        
        while top - bottom >= pow(10, -5):
            mid = (top + bottom) / 2
            
            res = count(mid)
            
            if res <= 0:
                top = mid
            else:
                bottom = mid
        return top
            
            